# Queue-Messaging
AeroQueue is a distributed message queuing system implementation designed to streamline and optimize real-time data processing.

## Features

- **Producer**: Component that sends messages to the queue.
- **Consumer**: Component that reads and processes messages from the queue.
- **Persistence**: Storage of messages to ensure durability.
- **Message Acknowledgement**: System to ensure that messages are correctly processed before being removed from the queue.
- **Retry System**: Attempt to reprocess messages that failed to process.
- **Dead-letter Queue**: Queue for messages that failed after several attempts.
- **Monitoring and Logging**: System to monitor and log the behavior of the queue.

## TODOs

### Data Structure
- [ ] Implement the `Queue` class with `enqueue` and `dequeue` methods.

### Persistence
- [ ] Choose and implement a persistence mechanism (e.g., SQLite, JSON file).
- [ ] Implement methods to save the queue.
- [ ] Implement methods to load the queue.

### Concurrency
- [ ] Implement locks to ensure the integrity of the queue with multiple threads/processes.

### Message Acknowledgement
- [ ] Implement the message acknowledgement system.
- [ ] Remove acknowledged messages from the queue.

### Retry System
- [ ] Add attempt counters for messages.
- [ ] Re-enqueue messages after failures.
- [ ] Implement a dead-letter queue for messages that failed after several attempts.

### Monitoring and Logging
- [ ] Implement a monitoring system to track the performance of the queue.
- [ ] Add detailed logging to diagnose problems and understand the system's behavior.

### Tests
- [ ] Write unit tests for the `Queue` class.
- [ ] Write integration tests for persistence.
- [ ] Write load tests to verify scalability.
