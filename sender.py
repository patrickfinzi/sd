#!/usr/bin/python 		# This is client .py file

import socket 			# Import socket module


s = socket.socket () 		

mCast_grupo = '224.1.1.1'
mCast_porta = 5007

sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM, socket.IPPROTO_UDP)
sock.setsockopt(socket.IPPROTO_IP, socket.IP_MULTICAST_TTL, 2)

msg='nada'

while(msg!='sair'):	
	msg = raw_input('Entre com a msg a ser enviada: ')
	sock.sendto(msg, (mCast_grupo, mCast_porta))  #envia msg para todos membros do grupo multicast
	print sock.recv(10240)



s.close

