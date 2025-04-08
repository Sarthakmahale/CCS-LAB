from Crypto.Cipher import AES
from secrets import token_bytes


def aes(): 
    key = token_bytes(16)

    # key=b'At&bSiO(qU@wXmZj'
    chi=AES.new(key, AES.MODE_EAX)
    print("Enter the data to encrypt-")
    msg=input().encode()

    nonce = chi.nonce

    C_text=chi.encrypt(msg)
    print("Cypher text", C_text)

    chi = AES.new(key, AES.MODE_EAX, nonce=nonce)
    P_text = chi.decrypt(C_text)
    print("Plain text ", P_text)

def des():
    key = token_bytes(8)

    # key=b'At&bSiO(qU@wXmZj'
    chi=DES.new(key, DES.MODE_EAX)
    print("Enter the data to encrypt-")
    msg=input().encode()

    nonce = chi.nonce

    C_text=chi.encrypt(msg)
    print("Cypher text", C_text)

    chi = DES.new(key, DES.MODE_EAX, nonce=nonce)
    P_text = chi.decrypt(C_text)
    print("Plain text ", P_text)


ch=input("enter your choice 1.AES \n 2.DES")
