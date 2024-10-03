document.addEventListener("DOMContentLoaded", function() {
    const sendButton = document.getElementById("sendButton");
    const userInput = document.getElementById("userInput");
    const chatArea = document.getElementById("chat-area");

    // Attach event listener to the send button and Enter key
    sendButton.addEventListener("click", sendMessage);
    userInput.addEventListener("keypress", function(event) {
        if (event.key === "Enter") {
            sendMessage();
        }
    });

    // This function sends the user's message to the backend and retrieves the AI response
    function sendMessage() {
        const message = userInput.value.trim();  // Get and trim the user's input
        if (!message) return;  // If the message is empty, don't send it

        // Send a GET request to the backend with the message as a query parameter
        fetch(`/chat?message=${encodeURIComponent(message)}`, {
            method: 'GET',  // Use GET method to send the message
        })
        .then(response => response.json())  // Parse the JSON response
        .then(data => {
            // Append user's message and bot's response to the chat area
            appendMessage("You", message);
            appendMessage("Bot", data.completion);
            chatArea.scrollTop = chatArea.scrollHeight;  // Auto-scroll to the bottom
        })
        .catch(error => {
            console.error('Error:', error);  // Log any errors
            appendMessage("Error", "Could not send message to the server.");
        });

        // Clear the input field after sending the message
        userInput.value = '';
    }

        // Utility function to append messages to the chat area
        function appendMessage(sender, message, isBot = false) {
            const messageElement = document.createElement('div');
            messageElement.classList.add('message');
    
            // Add avatar for the bot
            if (isBot) {
                const avatar = document.createElement('img');
                avatar.src = '/home/ducpm/code/chat-java/src/main/resources/templates/images.png';  // Spider-Man logo URL
                avatar.alt = 'Spider-Man Avatar';
                avatar.classList.add('avatar');  // Add a CSS class for styling
                messageElement.appendChild(avatar);
            }
    
            // Add message text
            const textElement = document.createElement('p');
            textElement.innerHTML = `<strong>${sender}:</strong> ${message}`;
            messageElement.appendChild(textElement);
    
            // Append the message to the chat area
            chatArea.appendChild(messageElement);
        }
});
