# Title         :       Ceaser Cypher Encryption and Decryption Using Symentric Key.
# Author        :       DSP

def Encryption_Decryption(Text: str, Key: str, Mode: str) -> str:
    ProcessedText: str = ""
    if Mode == "enc":
        for character in Text:
            ProcessedText = ProcessedText + chr((ord(character) + Key))
        else:
            print(ProcessedText)
    elif Mode == "dec":
        for character in Text:
            ProcessedText = ProcessedText + chr((ord(character) - Key))
        else:
            print(ProcessedText)
    return ProcessedText


def main():
    PlainText: str = str(input("Enter plain text\t:\t"))
    Key: str = ord(input("Enter key\t\t:\t"))
    EncryptedText: str = Encryption_Decryption(PlainText, Key, "enc")
    DecryptedText: str = Encryption_Decryption(EncryptedText, Key, "dec")
    print(
        f"Plain Text\t:\t{PlainText}\nEncryption Text\t:\t{EncryptedText}\nDecrypted Text\t:\t{DecryptedText}")


if __name__ == "__main__":
    main()
