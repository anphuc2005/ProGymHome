package com.example.progymhome.Lesson;

public enum LessonImage {
    BENCH_PRESS("D:\\Package IDE Java\\ProGYMHOME\\src\\main\\resources\\img\\bench-press.png"),
    DEAD_LIFT("D:\\Package IDE Java\\ProGYMHOME\\src\\main\\resources\\img\\deadlift.png"),
    DECLINE_PRESS("D:\\Package IDE Java\\ProGYMHOME\\src\\main\\resources\\img\\Decline Press.png"),
    DUMBBELL_PRESS("D:\\Package IDE Java\\ProGYMHOME\\src\\main\\resources\\img\\Dumbell Press.png"),
    FLY_MACHINE("D:\\Package IDE Java\\ProGYMHOME\\src\\main\\resources\\img\\Fly Machine.png"),
    DIPS("D:\\Package IDE Java\\ProGYMHOME\\src\\main\\resources\\img\\dips.png"),
    CHEST_PRESS_MACHINE("D:\\Package IDE Java\\ProGYMHOME\\src\\main\\resources\\img\\Chest Press Machine.png"),
    AB_ROLLER("D:\\Package IDE Java\\ProGYMHOME\\src\\main\\resources\\img\\Ab Roller.png"),
    BARBELL_MILITARY_PRESS("D:\\Package IDE Java\\ProGYMHOME\\src\\main\\resources\\img\\Barbell Military Press.png"),
    LATERAL_RAISES("D:\\Package IDE Java\\ProGYMHOME\\src\\main\\resources\\img\\Lateral Raises.png"),
    FRONT_DUMBBELL_RAISES("D:\\Package IDE Java\\ProGYMHOME\\src\\main\\resources\\img\\Front Dumbbell Raises.png"),
    CABLE_TRICEP("D:\\Package IDE Java\\ProGYMHOME\\src\\main\\resources\\img\\Cable Tricep.png"),
    OVERHEAD_TRICEP("D:\\Package IDE Java\\ProGYMHOME\\src\\main\\resources\\img\\Overhead Tricep.png"),
    PUSHDOWN_TRICEP("D:\\Package IDE Java\\ProGYMHOME\\src\\main\\resources\\img\\Pushdown Tricep.png"),
    PULL_UP("D:\\Package IDE Java\\ProGYMHOME\\src\\main\\resources\\img\\pull-up.png"),
    LAT_PULL_DOWN("D:\\Package IDE Java\\ProGYMHOME\\src\\main\\resources\\img\\lat-pulldown-machine.png"),
    SEATED_CABLE_ROW("D:\\Package IDE Java\\ProGYMHOME\\src\\main\\resources\\img\\Seated Cable Row.png"),
    SQUAT("D:\\Package IDE Java\\ProGYMHOME\\src\\main\\resources\\img\\squat.png"),
    BARBELL_SQUAT("D:\\Package IDE Java\\ProGYMHOME\\src\\main\\resources\\img\\Barbell Squat.png"),
    SPLIT_SQUAT("D:\\Package IDE Java\\ProGYMHOME\\src\\main\\resources\\img\\Split Squat.png"),
    HALF_SQUAT("D:\\Package IDE Java\\ProGYMHOME\\src\\main\\resources\\img\\Half Squat.png"),
    SHOULDER_PRESS("D:\\Package IDE Java\\ProGYMHOME\\src\\main\\resources\\img\\shoulder-press.png"),
    BICEP_CURL("D:\\Package IDE Java\\ProGYMHOME\\src\\main\\resources\\img\\bicep-curl.png"),
    TRICEP_CURL("D:\\Package IDE Java\\ProGYMHOME\\src\\main\\resources\\img\\tricep.png");

    private final String linkImage;

    LessonImage(String linkImage)
    {
        this.linkImage = linkImage;
    }

    public String getLinkImage() {
        return linkImage;
    }
}
