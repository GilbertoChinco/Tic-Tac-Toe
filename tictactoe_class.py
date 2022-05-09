from game_class import Game

class Tictactoe(Game):

    def __init__(self):
        self.positions_movements = {"A1":" ", "A2":" ", "A3":" ",
                                    "B1":" ", "B2":" ", "B3":" ",
                                    "C1":" ", "C2":" ", "C3":" "}
        self.position_movement_made = ["A1", "A2", "A3", "B1", "B2", "B3", "C1", "C2", "C3"]
        self.is_turn_O = True
        self.attempts = 0

    def play(self):

        while self.attempts < 10:
            #O's Player
            self.show_panel(self.positions_movements)
            combination = self.ask_position_movement()
            self.movement_player_O(combination)
            self.show_panel(self.positions_movements)
            if self.verify_attempts():
                break
            if self.verify_if_player_win("O"):
                winner_message = "O's player"
                break
            
            #X's Player
            combination = self.ask_position_movement()
            self.movement_player_X(combination)
            self.show_panel(self.positions_movements)
            if self.verify_attempts():
                break
            if self.verify_if_player_win("X"):
                winner_message = "X's player"
                break

        print(winner_message + " is the winner!!")    
        self.end()

    def movement_player_O(self, combination):
        self.positions_movements[combination] = "O"
        self.is_turn_O = False
        self.position_movement_made.remove(combination)
        self.attempts += 1

    def movement_player_X(self, combination):
        self.positions_movements[combination] = "X"
        self.is_turn_O = True
        self.position_movement_made.remove(combination)
        self.attempts += 1

    def ask_position_movement(self):
        print("Select the position, first the letter & second the number")
        if self.is_turn_O:
            print("O's Turn")
        else:
            print("X's Turn")
        
        while True:
            combination = input("Digit the combination: ")
            if self.verify_is_combination_correct(combination):
                if self.verify_combination_is_available(combination):
                    break
                else:
                    print("Digit a combination that has not been occupied")
            else:
                print("Digit a correct combination")

        return combination

    def verify_is_combination_correct(self, combination):
        if combination in ["A1", "A2", "A3", "B1", "B2", "B3", "C1", "C2", "C3"]:
            return True
        else:
            return False

    def verify_combination_is_available(self, number):
        if number in self.position_movement_made:
            return True
        else:
            return False

    def verify_attempts(self):
        if self.attempts == 9:
            return True
        else:
            return False

    def verify_if_player_win(self, player):
        index_positions = self.positions_movements.copy()

        #Horizontal lines
        if index_positions["A1"] == player and index_positions["A2"] == player and index_positions["A3"] == player:
            return True
        elif index_positions["B1"] == player and index_positions["B2"] == player and index_positions["B3"] == player:
            return True
        elif index_positions["C1"] == player and index_positions["C2"] == player and index_positions["C3"] == player:
            return True
        
        #Vertical Lines
        elif index_positions["A1"] == player and index_positions["B1"] == player and index_positions["C1"] == player:
            return True
        elif index_positions["A2"] == player and index_positions["B2"] == player and index_positions["C2"] == player:
            return True
        elif index_positions["A3"] == player and index_positions["B3"] == player and index_positions["C3"] == player:
            return True

        #Diagonal lines
        elif index_positions["A1"] == player and index_positions["B2"] == player and index_positions["C3"] == player:
            return True
        elif index_positions["A3"] == player and index_positions["B2"] == player and index_positions["C1"] == player:
            return True
        else:
            return False


    def show_panel(self, movements):
        print("  | 1 | 2 | 3 |")
        print("---.---.---.---.")
        print("A | " + str(movements["A1"]) + " | " + str(movements["A2"]) + " | " + str(movements["A3"]) + " |")
        print("---.---.---.---.")
        print("B | " + str(movements["B1"]) + " | " + str(movements["B2"]) + " | " + str(movements["B3"]) + " |")
        print("---.---.---.---.")
        print("C | " + str(movements["C1"]) + " | " + str(movements["C2"]) + " | " + str(movements["C3"]) + " |")
        print("---.---.---.---.")

    def reset(self):
        self.positions_movements = {"A1":" ", "A2":" ", "A3":" ",
                                    "B1":" ", "B2":" ", "B3":" ",
                                    "C1":" ", "C2":" ", "C3":" "}
        self.position_movement_made = ["A1", "A2", "A3", "B1", "B2", "B3", "C1", "C2", "C3"]
        self.is_turn_O = True
        self.attempts = 0

        

game = Tictactoe()
game.start()