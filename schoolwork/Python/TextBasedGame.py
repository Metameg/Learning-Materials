# Alex Metzger

def show_instructions():
    # Welcome message/ Instructions
    print("Welcome to the Office Space Adventure Game!")
    print("Collect 6 items to win the game, or be caught by your boss, Mr. Lumbergh. If you run into Mr. Lumbergh\n"
          "before you colect all 6 items, he will ask you to come into work on saturday and you lose the game.")
    print("Move Commands: go South, go North, go East, go West, exit")
    print(
        "Add to Inventory: get \'item name\'. Be sure to type the entire name of the item as some of the item names\n"
        "are quite long. SPACES AND CAPITALIZATION DOES NOT MATTER BUT SPELLING DOES!")
    print("The only time it is neccessary to use a space is after the go/get commands.")
    print("----------------------------------------------------------")


def move_room(room, command, current_room):
    """ This function first tests that the input direction is a valid direction for
        the current room. If so, change the current room to the room associated
        with the user_input direction. """

    if command in room.keys():
        new_room = room[command]  # This will change the current room to the room associated
        # with the direction key given in the second half (command_description)
        # of the user input
    else:
        print("You can't go that way!\n")
        new_room = current_room
    return new_room


def main():
    # A dictionary for the office
    # The dictionary links a room to other rooms as well as defines which items are in each room.
    rooms = {
        'Your Cubicle': {'east': 'Michael\'s Cubicle', 'north': 'Milton\'s Cubicle', 'south': 'Tom\'s Cubicle'},
        # start room
        'Michael\'s Cubicle': {'north': 'Conference Room', 'west': 'Your Cubicle',
                               'item': 'Computer Virus'},
        'Conference Room': {'south': 'Michael\'s Cubicle',
                            'item': 'TPS Report'},
        'Milton\'s Cubicle': {'east': 'Mr. Lumbergh\'s Office', 'south': 'Your Cubicle',
                              'item': 'Stapler'},
        'Tom\'s Cubicle': {'east': 'Copy Machine', 'west': 'Samir\'s Cubicle', 'north': 'Your Cubicle',
                           'item': 'Jump to Conclusions Mat'},
        'Copy Machine': {'west': 'Tom\'s Cubicle',
                         'item': 'Broken Copy Machine Part'},
        'Samir\'s Cubicle': {'east': 'Tom\'s Cubicle',
                             'item': 'How to pronounce Na-gheen-an-a-jar index card'},
        'Mr. Lumbergh\'s Office': ''  # villain
    }

    # Starts game loop, makes the starting room the Your Cubicle, and creates an empty inventory
    show_instructions()
    running = True
    current_room = 'Your Cubicle'
    inventory = []

    while running == True:

        # The first if-elif-else clause tests whether or not you are in the villain's room. If so and you have all 6 items, you win,
        # else you lose.

        if current_room == 'Mr. Lumbergh\'s Office' and len(inventory) == 6:
            print(
                'You successfully collected all of the items from around the office and place them on Mr. Lumbergh\'s desk\n'
                'as a token of his gratitude, he will not ask you to come into work on Saturday! Good job.')
            running = False

        elif current_room == '''Mr. Lumbergh's Office''' and len(inventory) != 6:
            print("Mr. Lumbergh caught you and asked you to come in on Saturday. sorry, you lose.")
            running = False

        else:
            # Prints current room, current inventory and prompts user for input

            print("You are in", current_room)
            if 'item' in rooms[current_room]:  # Tests if there is still an item in the current room
                print("You see a", rooms[current_room]['item'])
            print("Inventory: ", inventory)
            print('-------------')
            user_move = input("Enter your move:\n")

            # converts user input to all lower case letters in case user enters 'Go West', 'GO WEST', etc.
            user_move = user_move.lower()
            # converts input 'move' into a list of words seperated by whitespace
            move_list = user_move.split()

            # sets the first word of the newly created move_list to a variable called command. The rest of the move_list words
            # are joined into a single string with no spaces
            command = move_list[0]
            command_description = ''.join(move_list[1:])

            # Exit game loop command
            if user_move == 'exit':
                print("Entering exit room.\n Exiting game...")
                running = False

            # Main functionality of moving between rooms
            else:
                # The for loop iterates over the keys and values of the rooms dictionary that sets the format of the game map.
                # So, the room variable in the for loop will represent the key in the outer dictionary, and the room_dict will represent
                # the nested dictionaries (which contains the valid directions and items for each room).

                for room, room_dict in rooms.items():

                    # The first if statement makes the for loop skip all keys in the rooms dictionary except
                    # for the key (or room) that you are currently in
                    if room == current_room:
                        if command == 'go':  # Here we test if the command (or first word in the user input) is 'go'

                            current_room = move_room(room_dict, command_description,
                                                     current_room)  # move_room() defined above

                            break # Added to prevent the for loop continuing to run move_room() function, which can lead
                                  # to false error messages

                        elif command == 'get':  # Here we test if the command (or first word in the user input) is 'get'

                            # The if statement first tests:
                            # (1) If there is still an 'item' key in the nested dictionary room_dict
                            # (2) If the item that the user entered (command_description) is actually in the current room. Note that the value
                            # associated with the room's item had to be formatted in a way to match the format of the command_description (which
                            # is a string with no spaces or caps). To do this the .lower() and .replace(' ','') methods were used.
                            # strip() was also used in to ignore any spaces the user may have entered at the end of their input
                            # If the conditions are met, the item in the current room is appended to the inventory and
                            # the item key in the nested dictionary is removed. Else an error is printed.

                            if 'item' in room_dict.keys() and command_description == rooms[current_room][
                                'item'].lower().replace(' ', '').strip():
                                inventory.append(rooms[current_room]['item'])
                                del rooms[current_room]['item']
                            else:
                                print('That item is not in this room!\n')
                        else:
                            print("Enter a valid command!\n")


main()
