import pika
import time

# Conectar ao RabbitMQ
connection = pika.BlockingConnection(pika.ConnectionParameters('localhost'))
channel = connection.channel()

# Declarar a fila
channel.queue_declare(queue='hello')

for i in range(1, 11):
    message = f"Mensagem{i}"
    channel.basic_publish(exchange='',
                          routing_key='hello',
                          body=message)
    print(f" [x] Sent '{message}'")
    time.sleep(10)  # Espera 10 segundos

connection.close()
