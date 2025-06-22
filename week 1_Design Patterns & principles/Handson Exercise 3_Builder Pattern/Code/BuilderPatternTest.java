public class BuilderPatternTest {
    public static void main(String[] args) {
        Computer basicComputer = new Computer.Builder("Intel i3", "4GB").build();
        basicComputer.showSpecs();
        Computer officeComputer = new Computer.Builder("Intel i5", "8GB")
            .setStorage("512GB SSD")
            .setOperatingSystem("Windows 10")
            .build();
        officeComputer.showSpecs();
        Computer gamingComputer = new Computer.Builder("Intel i9", "32GB")
            .setStorage("1TB SSD")
            .setGraphicsCard("NVIDIA RTX 4090")
            .setOperatingSystem("Windows 11 Pro")
            .build();
        gamingComputer.showSpecs();
    }
}
