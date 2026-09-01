package com.Luv.juckbox;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static com.github.stefanbirkner.systemlambda.SystemLambda.*;

@DisplayName("APP TEST")
class AppTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void Application_Test() throws Exception{
        // Arrange
        Path inputFile = Paths.get("src", "test", "resources", "input_test.txt");
        List<String> arguments = new ArrayList<>(List.of("INPUT_FILE= "+inputFile.toString()));
    }

}
