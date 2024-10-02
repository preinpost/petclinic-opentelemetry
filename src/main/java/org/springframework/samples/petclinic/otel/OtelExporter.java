package org.springframework.samples.petclinic.otel;

import io.opentelemetry.exporter.logging.LoggingMetricExporter;
import io.opentelemetry.exporter.logging.LoggingSpanExporter;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import io.opentelemetry.exporter.otlp.logs.OtlpGrpcLogRecordExporter;
import io.opentelemetry.exporter.otlp.metrics.OtlpGrpcMetricExporter;
import io.opentelemetry.exporter.otlp.trace.OtlpGrpcSpanExporter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OtelExporter {

	private static final String endPoint = "http://localhost:9987";

	@Bean
	public OtlpGrpcSpanExporter otlpHttpSpanExporter() {
		return OtlpGrpcSpanExporter.builder().setEndpoint(endPoint).build();
	}

	@Bean
	public OtlpGrpcMetricExporter otlpGrpcMetricExporter() {
		return OtlpGrpcMetricExporter.builder().setEndpoint(endPoint).build();
	}

	@Bean
	public OtlpGrpcLogRecordExporter otlpGrpcLogRecordExporter() {
		return OtlpGrpcLogRecordExporter.builder().setEndpoint(endPoint).build();
	}

	@Bean
	public LoggingSpanExporter loggingSpanExporter() {
		return LoggingSpanExporter.create();
	}

	@Bean
	public LoggingMetricExporter loggingMetricExporter() {
		return LoggingMetricExporter.create();
	}

	@Bean
	public SystemOutLogRecordExporter batchLogRecordProcessor() {
		return SystemOutLogRecordExporter.create();
	}
}

