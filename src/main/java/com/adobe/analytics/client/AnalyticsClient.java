package com.adobe.analytics.client;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import static com.adobe.analytics.client.JsonUtil.GSON;

public class AnalyticsClient {

	private final String username;

	private final String password;

	private final String endpoint;

	public AnalyticsClient(final String username, final String password, final String endpoint) {
		this.username = username;
		this.password = password;
		this.endpoint = endpoint;
	}

	public <T> T callMethod(String method, Object data, Class<T> responseClass) throws IOException {
		return GSON.fromJson(callMethod(method, GSON.toJson(data)), responseClass);
	}

	public String callMethod(String method, String data) throws IOException {
		final URL url = new URL(endpoint + "?method=" + method);
		final URLConnection connection = url.openConnection();
		connection.addRequestProperty("X-WSSE", getHeader());
		connection.setDoOutput(true);

		IOUtils.write(data, connection.getOutputStream());
		return IOUtils.toString(connection.getInputStream());
	}

	private String getHeader() throws UnsupportedEncodingException {
		final String nonce = UUID.randomUUID().toString();
		final String created = currentDate();
		final String passwordDigest = getBase64Digest(nonce, created, password);
		final StringBuilder builder = new StringBuilder("UsernameToken ");
		addField(builder, "Username", username).append(", ");
		addField(builder, "PasswordDigest", passwordDigest).append(", ");
		addField(builder, "Nonce", Base64.encodeBase64String(nonce.getBytes())).append(", ");
		addField(builder, "Created", created);
		return builder.toString();
	}

	private static StringBuilder addField(StringBuilder builder, String fieldName, String fieldValue) {
		builder.append(fieldName).append("=\"").append(fieldValue).append('"');
		return builder;
	}

	private static String currentDate() {
		final TimeZone tz = TimeZone.getTimeZone("UTC");
		final DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
		df.setTimeZone(tz);
		return df.format(new Date());
	}

	private static String getBase64Digest(String... strings) {
		final MessageDigest digest = DigestUtils.getSha1Digest();
		digest.reset();
		for (final String s : strings) {
			DigestUtils.updateDigest(digest, s);
		}
		return Base64.encodeBase64String(digest.digest());
	}

}