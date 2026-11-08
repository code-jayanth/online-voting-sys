# Online Voting System

A console-based Java application for managing elections. Admins can control candidates and voting sessions, while voters can register, login, and cast one vote.

## Prerequisites
- Java JDK 8 or higher installed.
- All `.java` files in the same directory.

## Compilation
Open a terminal in the project directory and run:
```
javac *.java
```

## Running the Application
Run the application:
```
java Main
```

## Instructions: Create 10 Voters, 3 Candidates, and Make the 2nd Candidate Win

Follow these step-by-step instructions to set up the system, add candidates, register voters, and ensure the 2nd candidate wins by having all 10 voters vote for them.

### Step 1: Admin Login
1. At the Main Menu, choose `1` (Admin Login).
2. Enter Username: `admin`
3. Enter Password: `admin123`
4. You should see: "Admin login successful!"

### Step 2: Add 3 Candidates
1. In the Admin Menu, choose `1` (Add Candidate).
2. Enter candidate name: `Candidate A`
3. Repeat for the other two:
   - Choose `1` again, enter: `Candidate B`
   - Choose `1` again, enter: `Candidate C`
4. Choose `3` (View All Candidates) to confirm:
   - 1. Candidate A
   - 2. Candidate B
   - 3. Candidate C

### Step 3: Start Voting Session
1. In the Admin Menu, choose `4` (Start Voting Session).
2. You should see: "Voting session started."

### Step 4: Register 10 Voters
1. Logout from Admin: Choose `8` (Logout).
2. Back at Main Menu, choose `2` (Voter Registration).
3. Enter name: `Voter1`, password: `pass1`
4. Repeat for 9 more voters (choose `2` each time):
   - Voter2, pass2
   - Voter3, pass3
   - Voter4, pass4
   - Voter5, pass5
   - Voter6, pass6
   - Voter7, pass7
   - Voter8, pass8
   - Voter9, pass9
   - Voter10, pass10
5. Note the Voter IDs assigned (e.g., Voter1 gets ID 1, Voter2 gets ID 2, etc.).

### Step 5: Have All 10 Voters Vote for the 2nd Candidate (Candidate B)
1. For each voter, choose `3` (Voter Login) from Main Menu.
2. Enter Voter ID and password (e.g., ID: 1, password: pass1).
3. If login succeeds, you'll see the candidate list.
4. Enter Candidate ID to vote: `2` (for Candidate B).
5. Repeat for all 10 voters (IDs 1 through 10).
6. Each vote should confirm: "Vote cast successfully for candidate ID: 2"

### Step 6: End Voting Session and View Results
1. Admin Login again: Choose `1` from Main Menu, enter credentials.
2. Choose `5` (End Voting Session).
3. Choose `7` (View Final Results).
4. Expected output:
   - Candidate A: 0 votes
   - Candidate B: 10 votes
   - Candidate C: 0 votes
5. Candidate B wins!

### Additional Notes
- Voters can only vote once; attempting again shows "You have already voted."
- Voting only works during an active session.
- To reset, restart the application.
- For live results during voting, Admin can choose `6` (View Live Results).

## Features
- Admin: Manage candidates, control sessions, view results.
- Voter: Register, login, vote once.
- Validation: Prevents multiple votes, invalid logins, out-of-session voting.

## Troubleshooting
- If compilation fails, ensure JDK is installed and PATH is set.
- Invalid inputs prompt for re-entry.
- Exit anytime with `4` from Main Menu.