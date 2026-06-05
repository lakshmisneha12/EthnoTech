import java.util.Scanner;

// Node class for each post
class PostNode {
    String content;
    PostNode prev;
    PostNode next;

    public PostNode(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}

// Doubly Linked List for posts
class SocialMediaFeed {
    private PostNode head;
    private PostNode tail;
    private PostNode current; // Pointer to current post

    // Add a post at the end
    public void addPost(String content) {
        PostNode newNode = new PostNode(content);
        if (head == null) {
            head = tail = current = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Move to next post
    public void nextPost() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Moved to next post: " + current.content);
        } else {
            System.out.println("No next post available.");
        }
    }

    // Move to previous post
    public void prevPost() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Moved to previous post: " + current.content);
        } else {
            System.out.println("No previous post available.");
        }
    }

    // Delete current post
    public void deleteCurrentPost() {
        if (current == null) {
            System.out.println("No post to delete.");
            return;
        }

        System.out.println("Deleting post: " + current.content);

        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = current.next; // Deleted head
        }

        if (current.next != null) {
            current.next.prev = current.prev;
            current = current.next; // Move to next after deletion
        } else {
            tail = current.prev; // Deleted tail
            current = current.prev; // Move to previous
        }

        if (current != null) {
            System.out.println("Now viewing: " + current.content);
        } else {
            System.out.println("Feed is empty.");
        }
    }

    // Insert sponsor post at current position
    public void insertSponsorPost(String sponsorContent) {
        PostNode sponsor = new PostNode("[SPONSOR] " + sponsorContent);

        if (current == null) { // Empty feed
            head = tail = current = sponsor;
            return;
        }

        sponsor.prev = current.prev;
        sponsor.next = current;

        if (current.prev != null) {
            current.prev.next = sponsor;
        } else {
            head = sponsor; // Inserted at head
        }
        current.prev = sponsor;

        current = sponsor; // Move to sponsor post
        System.out.println("Inserted sponsor post: " + sponsor.content);
    }

    // Display all posts
    public void displayFeed() {
        if (head == null) {
            System.out.println("Feed is empty.");
            return;
        }
        System.out.print("Feed: ");
        PostNode temp = head;
        while (temp != null) {
            if (temp == current) {
                System.out.print("[" + temp.content + "] <-> ");
            } else {
                System.out.print(temp.content + " <-> ");
            }
            temp = temp.next;
        }
        System.out.println("null");
    }
}

// Main class
public class dll {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SocialMediaFeed feed = new SocialMediaFeed();

        // Sample posts
        feed.addPost("Post 1: Hello World!");
        feed.addPost("Post 2: Java is awesome!");
        feed.addPost("Post 3: Enjoying my coffee ☕");

        int choice;
        do {
            System.out.println("\n--- Social Media Navigation ---");
            feed.displayFeed();
            System.out.println("1. Next Post");
            System.out.println("2. Previous Post");
            System.out.println("3. Delete Current Post");
            System.out.println("4. Insert Sponsor Post");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input. Enter a number.");
                sc.next();
            }
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    feed.nextPost();
                    break;
                case 2:
                    feed.prevPost();
                    break;
                case 3:
                    feed.deleteCurrentPost();
                    break;
                case 4:
                    System.out.print("Enter sponsor content: ");
                    String sponsor = sc.nextLine();
                    feed.insertSponsorPost(sponsor);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        sc.close();
    }
}
