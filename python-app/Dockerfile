# Use the official Python image from the Docker Hub
FROM python:3.11

WORKDIR /appcreat

COPY . .

RUN pip install --no-cache-dir -r requirements.txt

EXPOSE 5000

CMD ["python", "app.py"]
