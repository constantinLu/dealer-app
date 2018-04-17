package com.dealer.commons.xml;

import com.dealer.commons.dto.Vehicle;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class GenerateSchema {

    public static void main(String[] args) throws JAXBException, IOException {

        JAXBContext context = JAXBContext.newInstance(Vehicle.class);

        //Generate an XML schema;
        context.generateSchema(new SchemaOutputResolver() {
            @Override
            public Result createOutput(String namespaceUri, String suggestedFileName) throws IOException {
                File outputFile = new File("resources/vehicleData.xsd");
                System.out.println("Generating file :  " + outputFile + " for namespaceUri: " + namespaceUri);
                return new StreamResult(outputFile);
            }
        });

    }
}
