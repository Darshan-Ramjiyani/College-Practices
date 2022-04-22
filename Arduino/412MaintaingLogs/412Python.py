from time import sleep
import serial
import sys
from datetime import date

PORT: str = "com9"
BAUD_RATE: int = 9600

CONN: serial.Serial = None

def main():
    setup()
    while True:
        loop()


def setup():
    global BAUD_RATE, CONN, PORT
    

    while True:
        try:
            display_messages("Connecting to the Aduino...")
            CONN = serial.Serial(PORT, BAUD_RATE)
            display_messages(
                f"Dwaidh terminal connected to the Arduino via {PORT} at {BAUD_RATE} bps.")
            break
        except serial.SerialException as e:
            display_messages(
                "Can not connect to the port. Try again in 2 mininutes. ")
            from time import sleep
            sleep(2000)

    while True:
        receive_data: str = CONN.readline().decode("ascii")
        if len(receive_data) > 0:
            if "Connected" in receive_data:
                display_messages("Arduino has successfully verify the connection.")
                break
            else:
                display_messages(f"Data Recieved :- {receive_data}", False)
        continue


def loop():
    receive_data: str = CONN.readline().decode("ascii")
        
    if len(receive_data) > 0:
        display_messages(receive_data, False)
        
        


def display_messages(display_message: str, isPythonPrompt = True):
    
    with open(f"{date.today().strftime('%d-%b-%Y')}.txt", "w+") as LOG_FILE:
        LOG_FILE.write(f"[{date.today()}]\t:\t{display_message}")
    
    LOG_FILE.close()
    
    if isPythonPrompt:
        print(f"[Python] : {display_message}")
    else:
        print(f"[Arduino]: {display_message}")

    return


if __name__ == "__main__":
    main()