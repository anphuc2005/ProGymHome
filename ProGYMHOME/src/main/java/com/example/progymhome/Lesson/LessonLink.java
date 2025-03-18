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
    MEDITATION("uwEaQk5VeS4"),
    DECLINE_PRESS("Kxt_5D2Rpgg"),
    FLY_MACHINE("sAeDw6xhFFw"),
    DIPS("o2qX3Zb5mvg"),
    CHEST_PRESS_MACHINE("vnd-GBtTMLI"),
    AB_ROLLER("zCsW9L2qi-0"),
    BARBELL_MILITARY_PRESS("cGnhixvC8uA"),
    LATERRAL_RAISES("XPPfnSEATJA"),
    FRONT_DUMBBELL_RAISES("5CECBjd7HLQ"),
    CABLE_TRICEP("6Fzep104f0s"),
    OVERHEAD_TRICEP("1u18yJELsh0"),
    PUSHDOWN_TRICEP("m_UlDFNX4mk"),
    LAT_PULL_DOWN("NAIEnMjN-6w"),
    SEATED_CABLE_ROW("UCXxvVItLoM"),
    BARBELL_SQUAT("-bJIpOq-LWk"),
    SPLIT_SQUAT("hXpGSa5HYqY"),
    HALF_SQUAT("njgjIZdpl50");



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
