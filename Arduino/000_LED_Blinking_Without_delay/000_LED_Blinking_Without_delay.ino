int led_red = 0;
int led_blue = 1;
int led_green = 2;
long current_time;

void setup() {
  
  pinMode(led_red, OUTPUT);
  pinMode(led_blue, OUTPUT);
  pinMode(led_green, OUTPUT);
  
  digitalWrite(led_red, LOW); 
  digitalWrite(led_blue, LOW);
  digitalWrite(led_green, LOW);
}

void loop() {
  /* Turn on RED LED for 5 sec */
  digitalWrite(led_red, HIGH);
  
  /* Wait for 5 sec*/
  current_time = millis();
  while(millis()!=current_time+5000){;}
  
  /* Turn off RED LED & Turn on BLUE LED for 5 sec */
  digitalWrite(led_red, LOW);   
  digitalWrite(led_blue, HIGH);
  
  /* Wait for 5 sec*/
  current_time = millis();
  while(millis()!=current_time+5000){;}
  
  /* Turn off BLUE LED & Turn on GREEN LED for 5 sec */
  digitalWrite(led_blue, LOW);   
  digitalWrite(led_green, HIGH);
  
  /* Wait for 5 sec*/
  current_time = millis();
  while(millis()!=current_time+5000){;}
  digitalWrite(led_green, LOW);
       
}