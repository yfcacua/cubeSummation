/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imaginamos.delegator;

import com.imaginamos.model.Case;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author yerson
 */
public class CubeDelegatorTest {

    public CubeDelegatorTest() {
    }

    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of testProcessingCaseOne method, of class CubeDelegator.
     */
    @Test
    public void testProcessingCaseOne() {
        List<Case> cases = new ArrayList<>();

        Case caseOne = new Case();

        //Tamaño del cubo N 
        caseOne.setN(2);

        //Operaciones de la prueba
        List<String> operaciones = new ArrayList<>();
        operaciones.add(" UPDATE 2 2 2 4");
        operaciones.add(" QUERY 1 1 1 3 3 3");
        operaciones.add(" UPDATE 1 1 1 23");
        operaciones.add(" QUERY 2 2 2 4 4 4");
        operaciones.add(" QUERY 1 1 1 3 3 3");

        caseOne.setOperations(operaciones);

        cases.add(caseOne);

        CubeDelegator instance = new CubeDelegator();

        //Valores esperados
        List<String> expResult = new ArrayList<>();
        expResult.add("4");
        expResult.add("4");
        expResult.add("27");

        //LLamado al metodo
        List<String> result = instance.processingCases(cases);

        System.out.println("Test testProcessingCaseOne");

        int c = 0;
        for (String _result : expResult) {
            assertEquals(expResult.get(c), result.get(c));
            c++;
        }

    }

    /**
     * Test of testProcessingCaseTwo method, of class CubeDelegator.
     */
    @Test
    public void testProcessingCaseTwo() {
        List<Case> cases = new ArrayList<>();

        Case caseTwo = new Case();

        //Tamaño del cubo N 
        caseTwo.setN(2);

        //Operaciones de la prueba
        List<String> operaciones = new ArrayList<>();
        operaciones.add(" UPDATE 2 2 2 1");
        operaciones.add(" QUERY 1 1 1 1 1 1");
        operaciones.add(" QUERY 1 1 1 2 2 2");
        operaciones.add(" QUERY 2 2 2 2 2 2");

        caseTwo.setOperations(operaciones);

        cases.add(caseTwo);

        CubeDelegator instance = new CubeDelegator();

        //Valores esperados
        List<String> expResult = new ArrayList<>();
        expResult.add("0");
        expResult.add("1");
        expResult.add("1");

        //LLamado al metodo
        List<String> result = instance.processingCases(cases);

        System.out.println("Test testProcessingCaseTwo");

        int c = 0;
        for (String _result : expResult) {
            assertEquals(expResult.get(c), result.get(c));
            c++;
        }

    }

    /**
     * Test of testProcessingCases method, of class CubeDelegator.
     */
    @Test
    public void testProcessingCases() {
        List<Case> cases = new ArrayList<>();

        Case caseTwo = new Case();

        //Tamaño del cubo N 
        caseTwo.setN(2);

        Case caseOne = new Case();

        //Tamaño del cubo N 
        caseOne.setN(2);

        //Operaciones de la prueba caso1
        List<String> operaciones = new ArrayList<>();
        operaciones.add(" UPDATE 2 2 2 4");
        operaciones.add(" QUERY 1 1 1 3 3 3");
        operaciones.add(" UPDATE 1 1 1 23");
        operaciones.add(" QUERY 2 2 2 4 4 4");
        operaciones.add(" QUERY 1 1 1 3 3 3");

        caseOne.setOperations(operaciones);

        cases.add(caseOne);

        //Operaciones de la prueba caso2
        operaciones = new ArrayList<>();
        operaciones.add(" UPDATE 2 2 2 1");
        operaciones.add(" QUERY 1 1 1 1 1 1");
        operaciones.add(" QUERY 1 1 1 2 2 2");
        operaciones.add(" QUERY 2 2 2 2 2 2");

        caseTwo.setOperations(operaciones);

        cases.add(caseTwo);

        CubeDelegator instance = new CubeDelegator();

        //Valores esperados
        List<String> expResult = new ArrayList<>();
        expResult.add("4");
        expResult.add("4");
        expResult.add("27");
        expResult.add("0");
        expResult.add("1");
        expResult.add("1");

        //LLamado al metodo
        List<String> result = instance.processingCases(cases);

        System.out.println("Test testProcessingCases");

        int c = 0;
        for (String _result : expResult) {
            assertEquals(expResult.get(c), result.get(c));
            c++;
        }

    }

}
