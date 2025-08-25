package org.ticketbooking.utility;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtility {

    public static String getHashedPassword(String plainPassword) {
        // 12 is the strength (log rounds) — higher = more secure but slower
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
    }

    // Compare plain password with hashed password
    public static Boolean comparePassword(String plainPassword, String hashedPassword) {
        if (plainPassword == null || hashedPassword == null) {
            return false;
        }
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
}
