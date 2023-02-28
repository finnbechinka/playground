using System;
using System.Collections.Generic;

namespace Superstar
{
    class Program
    {
        static string[] users;
        static string[,] connections;
        static void Main(string[] args)
        {
            bool run = true;
            while (run)
            {
                selectFile();
                Console.WriteLine("Superstar: " + checkForSuperstar());
            }
        }

        static string checkForSuperstar()
        {
            for (int i = 0; i < users.Length; i++)
            {
                string currUser = users[i];
                int followers = 0;
                for (int x = 0; x < users.Length; x++)
                {
                    string tmpUser = users[x];
                    if (currUser == tmpUser) continue;
                    bool bail = false;
                    if (bail) break;
                    for (int y = 0; y < connections.Length / 2; y++)
                    {
                        if (connections[y, 0] == currUser && connections[y, 1] == tmpUser)
                        {
                            bail = true;
                            break;
                        }
                        else if (connections[y, 0] == tmpUser && connections[y, 1] == currUser)
                        {
                            followers++;
                        }
                    }
                }
                if (followers == users.Length - 1)
                {
                    return currUser;
                }
            }
            return "There is no Superstar in this set!";
        }

        static void selectFile()
        {
            Console.Out.WriteLine("Select file number (1,2,3,4): ");
            int selection = Convert.ToInt32(Console.ReadLine());

            switch (selection)
            {
                case 1:
                    fillUsersAndConnections(readFile(1));
                    break;
                case 2:
                    fillUsersAndConnections(readFile(2));
                    break;
                case 3:
                    fillUsersAndConnections(readFile(3));
                    break;
                case 4:
                    fillUsersAndConnections(readFile(4));
                    break;
                default:
                    Console.WriteLine("Please enter a number between 1 and 4");
                    selectFile();
                    break;
            }
        }

        static string[] readFile(int selection)
        {
            switch (selection)
            {
                case 1:
                    string[] inputLines1 = System.IO.File.ReadAllLines(@"C:\Users\finn-\Documents\bwinf material\superstar\superstar1.txt");
                    return inputLines1;
                case 2:
                    string[] inputLines2 = System.IO.File.ReadAllLines(@"C:\Users\finn-\Documents\bwinf material\superstar\superstar2.txt");
                    return inputLines2;
                case 3:
                    string[] inputLines3 = System.IO.File.ReadAllLines(@"C:\Users\finn-\Documents\bwinf material\superstar\superstar3.txt");
                    return inputLines3;
                case 4:
                    string[] inputLines4 = System.IO.File.ReadAllLines(@"C:\Users\finn-\Documents\bwinf material\superstar\superstar4.txt");
                    return inputLines4;
                default:
                    return null;
            }
        }

        static void fillUsersAndConnections(string[] input)
        {
            users = input[0].Split(null);

            connections = new string[input.Length - 1, 2];

            for (int i = 1; i < input.Length; i++)
            {
                string[] tmp = input[i].Split(null);
                connections[i - 1, 0] = tmp[0];
                connections[i - 1, 1] = tmp[1];
            }
        }

    }
}
