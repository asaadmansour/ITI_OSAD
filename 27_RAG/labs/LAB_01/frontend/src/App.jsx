import React, { useState, useRef, useEffect } from 'react';
import ReactMarkdown from 'react-markdown';

// Generates the fallback Chef SVG icon if the image fails to load
const ChefIcon = () => (
  <svg className="logo-svg" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round">
    <path d="M6 13.87A4 4 0 0 1 7.41 6a5.11 5.11 0 0 1 1.05-1.54 5 5 0 0 1 7.08 0A5.11 5.11 0 0 1 16.59 6 4 4 0 0 1 18 13.87V21H6Z"></path>
    <line x1="6" y1="17" x2="18" y2="17"></line>
  </svg>
);

const SendIcon = () => (
  <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round">
    <line x1="22" y1="2" x2="11" y2="13"></line>
    <polygon points="22 2 15 22 11 13 2 9 22 2"></polygon>
  </svg>
);

function App() {
  const [messages, setMessages] = useState([
    { role: 'ai', content: 'Hello! I am your AI Chef. What would you like to cook today?' }
  ]);
  const [input, setInput] = useState('');
  const [isLoading, setIsLoading] = useState(false);
  const endOfMessagesRef = useRef(null);
  
  // Auto-scroll to bottom of chat
  useEffect(() => {
    endOfMessagesRef.current?.scrollIntoView({ behavior: 'smooth' });
  }, [messages, isLoading]);

  const handleSend = async () => {
    const userMessage = input.trim();
    if (!userMessage) return;

    // Add user message to UI immediately
    setMessages(prev => [...prev, { role: 'user', content: userMessage }]);
    setInput('');
    setIsLoading(true);

    try {
      const resp = await fetch('http://localhost:8000/chat', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({ message: userMessage })
      });

      if (!resp.ok) {
        throw new Error('Network response was not ok');
      }

      const data = await resp.json();
      
      // Update with AI response from data.response
      setMessages(prev => [...prev, { role: 'ai', content: data.response }]);
    } catch (error) {
      console.error('Error fetching chat:', error);
      setMessages(prev => [...prev, { role: 'ai', content: 'Sorry, I encountered an error. Is the Django API running?' }]);
    } finally {
      setIsLoading(false);
    }
  };

  const handleKeyDown = (e) => {
    if (e.key === 'Enter' && !e.shiftKey) {
      e.preventDefault();
      handleSend();
    }
  };

  return (
    <div className="app-container">
      {/* HEADER */}
      <header className="header">
        <div className="logo-container">
          {/* Defaulting to a generated valid avatar but providing a fallback via error handling */}
          <img src="/chef-logo.png" alt="AI Chef" onError={(e) => {
            e.target.style.display='none';
            e.target.nextSibling.style.display='block';
          }} />
          <div style={{display: 'none'}}><ChefIcon /></div>
        </div>
        <div className="header-texts">
          <h1>AI Chef Assistant</h1>
          <p>Powered by Next-Gen Intelligence</p>
        </div>
      </header>

      {/* CHAT AREA */}
      <div className="chat-container">
        {messages.map((msg, index) => (
          <div key={index} className={`message-wrapper ${msg.role}`}>
            {msg.role === 'ai' ? (
              <div className="avatar ai-avatar"><ChefIcon /></div>
            ) : (
              <div className="avatar user-avatar">U</div>
            )}
            
            <div className="message-content">
              {msg.role === 'ai' ? (
                <ReactMarkdown>{msg.content}</ReactMarkdown>
              ) : (
                msg.content
              )}
            </div>
          </div>
        ))}

        {isLoading && (
          <div className="message-wrapper ai">
            <div className="avatar ai-avatar"><ChefIcon /></div>
            <div className="message-content">
              <div className="typing-indicator">
                <div className="dot"></div>
                <div className="dot"></div>
                <div className="dot"></div>
              </div>
            </div>
          </div>
        )}
        
        <div ref={endOfMessagesRef} />
      </div>

      {/* INPUT AREA */}
      <div className="input-container">
        <div className="input-wrapper">
          <textarea
            value={input}
            onChange={(e) => setInput(e.target.value)}
            onKeyDown={handleKeyDown}
            placeholder="Ask about recipes, ingredients, or cooking..."
            disabled={isLoading}
            rows={1}
            style={{height: input ? `${Math.min(150, 48 + (input.split('\\n').length - 1) * 20)}px` : '48px'}}
          />
          <button 
            className="send-button"
            onClick={handleSend}
            disabled={!input.trim() || isLoading}
          >
            <SendIcon />
          </button>
        </div>
      </div>
    </div>
  );
}

export default App;
