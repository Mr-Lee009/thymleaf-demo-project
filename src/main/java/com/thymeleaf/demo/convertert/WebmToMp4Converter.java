package com.thymeleaf.demo.convertert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WebmToMp4Converter {
  public static void convertMkvToMp4(String inputPath, String outputPath) throws IOException, InterruptedException {

    String ffmpegLink = "C:\\Users\\ducla\\Downloads\\ffmpeg-2025-05-01-git-707c04fe06-full_build\\ffmpeg-2025-05-01-git-707c04fe06-full_build\\bin\\ffmpeg.exe";

    ProcessBuilder builder = new ProcessBuilder(
        ffmpegLink,
        "-i", inputPath,         // input file .mkv
        "-c:v", "libx264",       // video codec
        "-preset", "fast",       // encoding preset
        "-c:a", "aac",           // audio codec
        "-b:a", "128k",          // audio bitrate
        "-y",                    // overwrite output
        outputPath              // output file .mp4
    );

    builder.redirectErrorStream(true);
    Process process = builder.start();

    // Optional: In log ffmpeg
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
      String line;
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }
    }

    int exitCode = process.waitFor();
    if (exitCode == 0) {
      System.out.println("✅ Convert MKV to MP4 successfully.");
    } else {
      System.err.println("❌ Convert failed. Exit code: " + exitCode);
    }
  }

  public static void main(String[] args) {
    String inputFile = "C:\\Users\\ducla\\Downloads\\Venom.The.Last.Dance.2024.REPACK.1080p.AMZN.WEB-DL.WEB-DL.DDP5.1.Atmos.H.264-FLUX.mkv";
    String outputFile = "C:\\Users\\ducla\\Downloads\\video_output.mp4";

    try {
      convertMkvToMp4(inputFile, outputFile);
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }
  }

}
