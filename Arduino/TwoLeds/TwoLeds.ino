/*
 * Blink two LED. (Defination3)
 * @author: DSP
 * Licence: Apache 2.0
 */


 int led1 = 7;
 int led2 = 6;

 void setup()
 {
    pinMode(led1, OUTPUT);
    pinMode(led2, OUTPUT);
 }

void loop()
{
    digitalWrite(led1, HIGH);
    delay(100);
    digitalWrite(led1, LOW);
    digitalWrite(led2, HIGH);
    delay(100);
    digitalWrite(led2, LOW);
    delay(100);
    
    digitalWrite(led2, HIGH);
    delay(100);
    digitalWrite(led2, LOW);
    digitalWrite(led1, HIGH);
    delay(100);
    digitalWrite(led1, LOW);
    delay(500);
}
