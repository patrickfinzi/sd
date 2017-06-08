#!/usr/bin/python 		

import socket 			
import struct

sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM, socket.IPPROTO_UDP)
sock.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
mCast_grupo = '224.1.1.1'
mCast_porta = 5007
sock.bind((mCast_grupo, mCast_porta))        

mreq = struct.pack("4sl", socket.inet_aton(mCast_grupo), socket.INADDR_ANY)

sock.setsockopt(socket.IPPROTO_IP, socket.IP_ADD_MEMBERSHIP, mreq)


while True:
	msg = sock.recv(10240)
	print 'A string <'+msg+'> foi enviada para os membros do grupo multicast - '+mCast_grupo  

        
sock.close () 

