class Game:
    
    def start(self):
        while True:
            start = input("Would you like to play?: ")
            if start.lower() == "yes":
                break
            
        self.play()

    def end(self):
        print("The game has ended")
        self.reset()

    def play(self):
        raise NotImplementedError("You must provide an implementation for play()")

    def reset(self):
        raise NotImplementedError("You must provide an implementation for reset()")
