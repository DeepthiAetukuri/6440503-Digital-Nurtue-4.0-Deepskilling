public class Computer {
    private final String CPU;
    private final String RAM;
    private final String storage;
    private final String graphicsCard;
    private final String operatingSystem;
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.operatingSystem = builder.operatingSystem;
    }
    public void showSpecs() {
        System.out.println("=== Computer Configuration ===");
        System.out.println("CPU: " + CPU);
        System.out.println("RAM: " + RAM);
        System.out.println("Storage: " + (storage != null ? storage : "Not specified"));
        System.out.println("Graphics Card: " + (graphicsCard != null ? graphicsCard : "Not specified"));
        System.out.println("Operating System: " + (operatingSystem != null ? operatingSystem : "Not specified"));
        System.out.println();
    }
    public static class Builder {
        private final String CPU;
        private final String RAM;
        private String storage;
        private String graphicsCard;
        private String operatingSystem;
        public Builder(String CPU, String RAM) {
            this.CPU = CPU;
            this.RAM = RAM;
        }
        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }
        public Builder setGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }
        public Builder setOperatingSystem(String operatingSystem) {
            this.operatingSystem = operatingSystem;
            return this;
        }
        public Computer build() {
            return new Computer(this);
        }
    }
}
