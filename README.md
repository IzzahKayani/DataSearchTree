Name: Izzah Kayani ID:49249154

Output:

Search for id: cc2083338a16c3fe2f7895289d2e98fe
Id: cc2083338a16c3fe2f7895289d2e98fe
Name: ARTSCAPE Etched Glass 24 x 36 Window Film, 24-by-36-Inch
Category: Home & Kitchen | Home Décor | Window Treatments | Window Stickers & Films | Window Films
Price: $12.99 

Search for id: f8c32a45e507a177992973cf0d46d20c
Id: f8c32a45e507a177992973cf0d46d20c
Name: Terra by Battat – 4 Dinosaur Toys, Medium – Dinosaurs for Kids & Collectors, Scientifically Accurate & Designed by A Paleo-Artist; Age 3+ (4 Pc)
Category: No entry given
Price: $18.66 

Search for id: e04b990e95bf73bbe6a3fa09785d7cd0
Id: e04b990e95bf73bbe6a3fa09785d7cd0
Name: Woodstock- Collage 500 pc Puzzle
Category: Toys & Games | Puzzles | Jigsaw Puzzles
Price: $17.49 

Now inserting a duplicate product id that is already in the tree
Error: user ID already exists

Now inserting a brand new product and id
Searching the id that was just inserted to make sure it was properly implemented into the tree:
Id: 2bb91aefb3468ed83860e0e2711c5f10
Name: IPhone 13 Case
Category: Phone Cases 
Price: $11.59

Performance Analysis: 
While this red-black tree's search function is written the same as an elementary binary tree, it ultimately runs faster due to it's branches having a better balance. Since red-black trees are approximately balanced, no leaf is more than twice the length as another leaf. Consequently, no node has a depth more than 2log(N), where N is the number of nodes in a tree. This makes the runtime for search and insert both 0log(N), where time goes up linearly while N goes up exponentially. In this program, the tree handles around 10,000 nodes efficiently through it's insertion following the rules of a left leaning red-black tree. These rules mainly being that there can't be two left red links in a row, or a red link which ultimately results in there being no two red links in a row. 
