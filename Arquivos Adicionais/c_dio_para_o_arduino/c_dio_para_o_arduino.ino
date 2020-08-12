


// the loop function runs over and over again forever
int ledPin13 = 13;
void setup(){
  Serial.begin(9600);

  pinMode(ledPin13, OUTPUT);
}

void loop() {
  char caracter;
  caracter = Serial.read();

  if(caracter == 'a')
  {
      digitalWrite(ledPin13, HIGH);   // turn the LED on (HIGH is the voltage level)
      delay(1000);                       // wait for a second
      digitalWrite(LED_BUILTIN, LOW);    // turn the LED off by making the voltage LOW
      delay(1000);   
  }
}
