/* 
 *  -- Preface --
 *   
 *   Serial Communication : Serial communication is a communication method that uses one or two transmission lines to send and receive data, 
 *   and that data is continuously sent and received one bit at a time
 *   
 *   Baugh Rate : Specify the transfer rate at which data will be transfer through Serial Communication.
 *   9600 baugh rate means it can pass 9600 bits per seconds(bps) through Serial Communication.
 *   
 *   Author : DSP
*/

int number = 1;

void setup()
{
  
  int baughRate = 9600; 

  /* Established Serial Communication. */
  Serial.begin(baughRate);

  /* Wait until Serial Communication not established. */
  while(!Serial){}

  /* Send data through Serial Communication. */
  Serial.println("(*) First Program (*)"); //adds new line after send text passed to it as param.
  Serial.println("- Name of Author : DSP -"); 
  Serial.println("---------------------------------------------------------");
}

void loop() 
{
  Serial.print(number); // print in countinouse line.
  Serial.print(","); 
  delay(2000); // wait for 2 seconds.
  number++;
}
