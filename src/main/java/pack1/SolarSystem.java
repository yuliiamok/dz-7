package pack1;

public enum SolarSystem {
    MERCURY (0, 2430, null),
    VENUS (55000000, 4613, MERCURY),
    EARTH (675000000, 6378, VENUS),
    MARS (767800000, 9773, EARTH),
    JUPITER (443500000, 33169, MARS),
    SATURN (649000000, 58410, JUPITER),
    URANUS (1443000000, 122330, SATURN),
    NEPTUNE (50000000, 191340, URANUS);
    private static final int FROM_SUN_TO_MERCURY = 1000;
    final private int prevDistance; // km
    final private int radius; // km
    final private SolarSystem previous;
    private SolarSystem next;
    final private int distanceToSun;
    final private int index = ordinal()+1;

    SolarSystem(int prevDistance, int radius, SolarSystem previous) {
        this.prevDistance = prevDistance;
        this.radius = radius;
        this.previous = previous;
        if (previous == null) {
            distanceToSun = FROM_SUN_TO_MERCURY;
        } else {
            distanceToSun = previous.getDistanceToSun() + prevDistance;
            previous.setNext(this);
        }
    }

    private int getDistanceToSun() {
        return this.distanceToSun;
    }
    public SolarSystem getNext() {
        return next;
    }
    public void setNext(SolarSystem next) {
        this.next = next;
    }
    @Override
    public String toString() {
        return String.format("%s - it's %d planet from Sun, the radius: %d km, the distance to Sun: %d km",
                this.name(), index, radius, distanceToSun);
    }
}
