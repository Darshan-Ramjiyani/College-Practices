int redLedPin = 11;
int greenLedPin = 10;

int hallMagneticSensor = 3; //hallMagneticSensor pin
int val; //numeric variable

void setup()
{
	pinMode(redLedPin, OUTPUT);
    pinMode(greenLedPin, OUTPUT);
	pinMode(hallMagneticSensor, INPUT);

    while (!Serial)
    {
        Serial.begin(9600);
    }

    Serial.println("Serial connection has been established.");
    
}
void loop()
{
	val = digitalRead(hallMagneticSensor); //Read the hallMagneticSensor
	if(val == LOW) //when magnetic field is detected, turn led on
	{
		digitalWrite(Led, HIGH);
        turnLedOn(greenLedPin, redLedPin);
        Serial.println("Magnetic Field Found.");
	}
	else
	{
        turnLedOn(redLedPin, greenLedPin);
	}
}

void turnLedOn(int ledToOff, ledToOn)
{
    digitalWrite(ledToOff, LOW);
    digitalWrite(ledToOn, HIGH);
}