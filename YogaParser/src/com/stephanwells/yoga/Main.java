package com.stephanwells.yoga;

import java.io.*;

public class Main
{
    public static final String TEST_EVTC_PATH = "test.evtc";
    public static final int BUFFER_SIZE = 64;

    public static void main(String[] args)
    {
        BufferedInputStream bis = null;
        try
        {
            bis = new BufferedInputStream(new FileInputStream(TEST_EVTC_PATH));
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Error. Cannot find EVTC file.");
        }

        int read;
        byte[] buffer = new byte[BUFFER_SIZE];

        try
        {
            bis.read(buffer);
            System.out.println(buffer);
        }
        catch (IOException e)
        {
            System.out.println("Error. EVTC file unable to be read: " + e.getMessage());
        }
    }
}