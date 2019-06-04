package com.superm.easy.cloud.commons.support;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.apache.commons.lang3.time.DateUtils;

import java.io.IOException;
import java.util.Date;

public class UnixTimestampSerializer extends JsonSerializer<Date> {

	@Override
	public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider)
					throws IOException, JsonProcessingException {
		jgen.writeString(value.getTime() / DateUtils.MILLIS_PER_SECOND + "");
	}

}
