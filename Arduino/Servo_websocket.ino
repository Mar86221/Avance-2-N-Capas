
#include <ESP32Servo.h>
#include <WiFi.h>
#include <WebSocketsClient.h>
#include <Servo.h>

const char* ssid = "iPhone";
const char* password = "V33eEr553Ft";

const char* websocket_server_host = "localhost";
const int websocket_server_port = 8080;
const char* websocket_path = "/servo";

WebSocketsClient webSocket;
Servo myServo;
const int servoPin = 9;

void setup() {
  Serial.begin(115200);

  // Connect to Wi-Fi
  WiFi.begin(ssid, password);
  while (WiFi.status() != WL_CONNECTED) {
    delay(1000);
    Serial.println("Connecting to WiFi...");
  }
  Serial.println("Connected to WiFi");

  // Initialize servo
  myServo.attach(servoPin);
  myServo.write(0);

  // Initialize WebSocket
  webSocket.begin(websocket_server_host, websocket_server_port, websocket_path);
  webSocket.onEvent(webSocketEvent);
}

void loop() {
  webSocket.loop();
}

void webSocketEvent(WStype_t type, uint8_t * payload, size_t length) {
  switch(type) {
    case WStype_DISCONNECTED:
      Serial.println("Disconnected from WebSocket server");
      break;
    case WStype_CONNECTED:
      Serial.println("Connected to WebSocket server");
      webSocket.sendTXT("Hello server");
      break;
    case WStype_TEXT:
      Serial.printf("Received text: %s\n", payload);
      String message = String((char*)payload);
      if (message.startsWith("move")) {
        int angle = message.substring(5).toInt();
        myServo.write(angle);
      }
      break;
  }
}





