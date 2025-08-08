# Bank Queue Simulation System

Simulates customer service in a bank with priority queues for special clients.

## Features
- Simulates 2 cashiers and 1 platform service
- Handles 20+ clients with different priorities
- Priority given to:
  - Pregnant women
  - Elderly (65+)
  - Disabled persons
- Service times between 500-1000ms
- Real-time status updates

## Project Structure

```text
bank-simulation/
├── src/
│   ├── main/
│   │   └── java/
│   │      └── university/
│   │          └── jala/
│   │              └── bank_simulation/
│   │                  ├── model/
│   │                  │   ├── Client.java
│   │                  │   ├── ServiceType.java
│   │                  │   └── PriorityType.java
│   │                  ├── service/
│   │                  │   ├── QueueManager.java
│   │                  │   └── ServicePoint.java
│   │                  └── BankSimulation.java
│   └──  resources/
├── test/
│   └── java/
│       └── university/
│           └── jala/
│               └── bank_simulation/
│                   ├── model/
│                   │   ├── ClientTest.java
│                   │   └── PriorityTypeTest.java
│                   └── service/
│                       └── QueueManagerTest.java
├── pom.xml
├── README.md
└── diagrams/
    ├── class_diagram.puml
    └── sequence_diagram.puml
```

## Class Diagram
![Class Diagram](https://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/Jala-University/bank-simulation/main/diagrams/class_diagram.puml)

## Sequence Diagram
![Sequence Diagram](https://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/Jala-University/bank-simulation/main/diagrams/sequence_diagram.puml)

## Installation
1. Ensure JDK 21+ is installed
2. Clone repository:
   ```bash
   git clone https://github.com/Jala-University/bank-simulation.git
   ```
3. Build with Maven:
   ```bash
   cd bank-simulation
   mvn clean package
   ```

## Usage
Run the simulation:
```bash
java -jar target/bank-simulation-1.0-SNAPSHOT.jar
```

Sample Output:
```
c1, en espera
c2, en espera
...
c4, en atención Caja1
c5, en atención Plataforma1
...
c4, servido
c5, servido
...
```

## Testing
Run unit tests:
```bash
mvn test
```

## Design Patterns
- Producer-Consumer pattern for queue management
- Priority Queue for client handling
- Thread Pool for service points

## Best Practices
- Immutable data objects
- Thread-safe collections
- Proper resource cleanup
- Comprehensive unit tests
- Clear separation of concerns

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contributing

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## Acknowledgments

- Jala University for providing the educational framework
- Contributors and reviewers who helped improve this simulation
- PlantUML community for diagram tools

This implementation follows SOLID principles, uses proper Java 21 features, and includes comprehensive documentation as requested.