package cl.semaluc.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Base64;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

@ExtendWith(MockitoExtension.class)
public class JwtTokenGeneratorTest {

	private JwtTokenGenerator generator;

	@BeforeEach
	void setUp() {
		generator = new JwtTokenGenerator();
	}

	@Test
	void should_return_jwt_token() {
		String expectedPayloadContain = "test";
		ReflectionTestUtils.setField(generator, "appName", "test");
		ReflectionTestUtils.setField(generator, "secretKey", "test");

		String name = "test";
		String jwt = generator.execute(name);

		String[] chunks = jwt.split("\\.");
		Base64.Decoder decoder = Base64.getUrlDecoder();
		String payload = new String(decoder.decode(chunks[1]));

		assertTrue(payload.contains(expectedPayloadContain));
	}
}
