from PIL import Image, ImageDraw

def drawRocket(xPos, yPos, color):
    img.rectangle([35 + xPos, 60 + yPos, 85 + xPos, 70 + yPos], outline = color)
    img.ellipse([55 + xPos, 70 + yPos, 65 + xPos, 100 + yPos], outline = color)
    img.rectangle([50 + xPos, 10 + yPos, 70 + xPos, 60 + yPos], outline = color)
    img.rectangle([55 + xPos, 1 + yPos, 65 + xPos, 10 + yPos], outline = color)

def frameToFile(num):
    paddedNum = f"{num:02}"
    fileName = "frame" + paddedNum + "Rocket.jpg"
    canvas.save(fileName)

def drawRockets():
    xPos = 180
    for pos in range(20, 340, 1):
        drawRocket(xPos, 350-pos, (255, 0, 0))
        frameToFile(int((pos-20)/50))
        drawRocket(xPos, 350-pos, (255, 255, 255))

canvas = Image.new("RGB", (480, 380), (255, 255, 255))
img = ImageDraw.Draw(canvas)
drawRockets()