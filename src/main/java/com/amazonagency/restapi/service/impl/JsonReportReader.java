package com.amazonagency.restapi.service.impl;

import com.amazonagency.restapi.exception.ReportReaderException;
import com.amazonagency.restapi.model.data.Report;
import com.amazonagency.restapi.service.ReportReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class JsonReportReader implements ReportReader {
    private final ObjectMapper objectMapper;
    @Value("${data.source.path}")
    private String path;

    @Override
    public Report read() {
        try (InputStream inputStream = new FileInputStream(path)) {
            return objectMapper.readValue(inputStream, Report.class);
        } catch (IOException e) {
            throw new ReportReaderException("Can't read report from: " + path, e);
        }
    }
}
