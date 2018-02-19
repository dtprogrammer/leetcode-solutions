package dtprogrammer.github.io.p721;

import java.util.*;

/**
 * 721. Accounts Merge
 */
public class Solution {
    class UF {
        Map<String, Node> emailAccounts;

        class Node {
            String data;
            Node parent;
            int rank;

            public Node(String data) {
                this.data = data;
                this.rank = 0;
                this.parent = this;
            }
        }

        UF() {
            emailAccounts = new HashMap<>();
        }

        public String findSet(String email) {
            return findSet(emailAccounts.get(email)).data;
        }

        private Node findSet(Node node) {
            while (node != node.parent) {
                node.parent = emailAccounts.get(node.parent.data).parent;
                node = node.parent;
            }
            return node;
        }

        private void makeSet(String email) {
            emailAccounts.put(email, new Node(email));
        }

        public void union(String email1, String email2) {
            if (!emailAccounts.containsKey(email1)) {
                makeSet(email1);
            }

            if (!emailAccounts.containsKey(email2)) {
                makeSet(email2);
            }

            Node parent1 = findSet(emailAccounts.get(email1));
            Node parent2 = findSet(emailAccounts.get(email2));

            if (parent1 == parent2) {
                return;
            }

            if (parent1.rank < parent2.rank) {
                parent1.parent = parent2;
            } else {
                parent2.parent = parent1;
                parent1.rank++;
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        Map<String, String> emailToName = new HashMap<>();
        UF uf = new UF();

        for (List<String> account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                emailToName.put(account.get(i), account.get(0));
                uf.union(account.get(1), account.get(i));
            }
        }

        Map<String, List<String>> emails = new HashMap<>();
        for (String email : emailToName.keySet()) {
            String parentEmail = uf.findSet(email);
            emails.computeIfAbsent(parentEmail, x -> new LinkedList<>()).add(email);
        }

        for (List<String> perUserEmails : emails.values()) {
            Collections.sort(perUserEmails);
            perUserEmails.add(0, emailToName.get(perUserEmails.get(0)));
        }

        return new ArrayList<>(emails.values());
    }
}
