package com.example.progymhome.Lesson;

public enum LessonLink {
    BENCH_PRESS("gRVjAtPip0Y"),
    DEAD_LIFT("XxWcirHIwVo"),
    SHOULDER_PRESS("F3QY5vMz_6I"),
    BICEP_CURL("XE_pHwbst04"),
    TRICEP_CURL("8nWNyQaEbaM"),
    SQUAT("SiVcGBGQ3Rk"),
    PUSH_UP("WDIpL0pjun0"),
    PULL_UP("aAggnpPyR6E"),
    CHILLING("JYNa_9pYLGw"),
    WARM_UP("-p0PA9Zt8zk"),
    MEDITATION("uwEaQk5VeS4");

    private final String videoID;

    LessonLink(String videoID)
    {
        this.videoID = videoID;
    }
    public String getVideoID()
    {
        return videoID;
    }



}
