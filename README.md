# Computer Networks in Java

This repository contains a collection of programs demonstrating various concepts in computer networks implemented using Java, AWK, and Tcl scripts.

## Program 1: CRC (Cyclic Redundancy Check)
- **Description:** This Java program implements CRC (Cyclic Redundancy Check) for error detection in transmitted messages.
- **Functionality:** It takes input for message bits and generated bits, appends zeros to the message, computes CRC, and detects errors in the received message.
- **File:** [CRC.java](https://github.com/pratham-pai/Computer-Networks-in-Java/blob/main/Program%201%20CRC/crc.java)

## Program 2: Bellman-Ford Algorithm
- **Description:** This Java program implements the Bellman-Ford algorithm for finding the shortest paths in a weighted graph.
- **Functionality:** It calculates the shortest distance between nodes in a graph using the Bellman-Ford algorithm.
- **File:** [Bellman.java](https://github.com/pratham-pai/Computer-Networks-in-Java/blob/main/Program%202%20BellmanFord/Bellman.java)

## Program 3: Content Client and Server
- **Description:** This Java program implements a client-server model for fetching content from the server.
- **Functionality:** The client sends a request for a file to the server, and the server responds with the content of the requested file.
- **Files:** [contentclient.java](https://github.com/pratham-pai/Computer-Networks-in-Java/blob/main/Program%203%20ClientServer%20TCP/contentclient.java) (Client), [contentserver.java](https://github.com/pratham-pai/Computer-Networks-in-Java/blob/main/Program%203%20ClientServer%20TCP/contentserver.java) (Server)

## Program 4: UDP Communication
- **Description:** This Java program demonstrates UDP (User Datagram Protocol) communication between a client and a server.
- **Functionality:** The client sends a message to the server using UDP, and the server echoes the message back to the client.
- **Files:** [udpc.java]([udpc.java](https://github.com/pratham-pai/Computer-Networks-in-Java/blob/main/Program%204%20ContentServer%20UDP/udpc.java)) (Client), [udps.java](https://github.com/pratham-pai/Computer-Networks-in-Java/blob/main/Program%204%20ContentServer%20UDP/udps.java) (Server)

## Program 5: RSA Encryption and Decryption
- **Description:** This Java program implements RSA (Rivest-Shamir-Adleman) encryption and decryption.
- **Functionality:** It encrypts and decrypts a message using RSA encryption algorithm.
- **File:** [RSA12.java](https://github.com/pratham-pai/Computer-Networks-in-Java/blob/main/Program%205%20RSA/RSA12.java)

## Program 6: Leaky Bucket Algorithm
- **Description:** This Java program simulates the leaky bucket algorithm for traffic shaping.
- **Functionality:** It calculates the required bandwidth and simulates data transmission using the leaky bucket algorithm.
- **File:** [leaky.java](https://github.com/pratham-pai/Computer-Networks-in-Java/blob/main/Program%206%20Leaky%20Bucket/leaky.java)

## Program 7: AWK Script for Packet Analysis
- **Description:** This AWK script analyzes packet traces and counts the number of dropped packets.
- **Functionality:** It reads packet traces and identifies dropped packets, then outputs the count of dropped packets.
- **AWK Script:** [pa1.awk](https://github.com/pratham-pai/Computer-Networks-in-Java/blob/main/Program%207/pa1.awk)
- **TCL Script:** [pa1.tcl](https://github.com/pratham-pai/Computer-Networks-in-Java/blob/main/Program%207/pa1.tcl)

## Program 8: AWK Script for Congestion Analysis
- **Description:** This AWK script analyzes packet traces and counts the number of dropped packets due to congestion.
- **Functionality:** It reads packet traces and identifies dropped packets due to congestion, then outputs the count.
- **AWK Script:** [pa2.awk](https://github.com/pratham-pai/Computer-Networks-in-Java/blob/main/Program%208/pa2.awk)
- **TCL Script:** [pa2.tcl](https://github.com/pratham-pai/Computer-Networks-in-Java/blob/main/Program%208/pa2.tcl)

## Program 9: Tcl Script for Network Simulation
- **Description:** This Tcl script simulates a network topology and traffic using the ns-2 network simulator.
- **Functionality:** It sets up nodes, links, and traffic sources in a network simulation scenario.
- **AWK Script:** [pa3.awk](https://github.com/pratham-pai/Computer-Networks-in-Java/blob/main/Program%209/pa3.awk)
- **TCL Script:** [pa3.tcl](https://github.com/pratham-pai/Computer-Networks-in-Java/blob/main/Program%209/pa3.tcl)

## Usage
Each program can be compiled and executed individually according to its specific instructions.

## Note
These programs are provided for educational purposes and can be used as references for understanding various computer networking concepts and algorithms.

## Repository Information
- **Name:** Computer Networks in Java
- **License:** None (provided for educational purposes)
