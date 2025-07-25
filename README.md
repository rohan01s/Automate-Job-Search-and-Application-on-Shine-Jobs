# Shine Automation Selenium Project

This project automates the job application process on [Shine.com](https://www.shine.com/), from logging in to applying for jobs using Selenium WebDriver in Java. The automation script covers steps like login, searching for a job, and clicking on the apply button, capturing screenshots at each stage.

## 🚀 Project Overview

- **Objective:** Automate the Shine.com job application process using Selenium.
- **Key Features:**
  - Login automation.
  - Job search using specific keywords.
  - Clicking on job details and applying automatically.
  - Captures screenshots at key steps (login, search, job details, application).
  - Handles exceptions and logs errors where necessary.

## 🛠️ Tech Stack

- **Language:** Java
- **Automation Tool:** Selenium WebDriver
- **Build Tool:** Maven
- **Driver Management:** WebDriverManager
- **IDE:** Eclipse/IntelliJ IDEA
- **Browser:** Google Chrome
- **Dependencies:** Selenium, WebDriverManager, TestNG/JUnit (if applicable)
- **OS:** Windows 11

How the Automation Works
✅ Login:

Navigates to Shine.com login page.
Enters username and password (configured in code).
Takes a screenshot after successful login.

✅ Job Search:

Searches for jobs using pre-defined keywords (configured in code).
Captures a screenshot after entering search details.

✅ Job Application:

Selects a job from the search results.
Clicks on Apply button.
Waits for confirmation or status change.
Captures screenshots after applying.

✅ Error Handling:

Uses try-catch blocks to handle missing elements or errors gracefully.
Logs all important actions.

📸 Screenshots
Screenshots are saved in the screenshots/ folder during execution:
login_success.png
search_details_entered.png
applied_success.png

🚨 Known Issues
Some dynamic elements on Shine.com might change (class names, ids).
Application status might not update instantly; sometimes it still shows "Apply" instead of "Applied."
CDP warning related to ChromeDriver version mismatch (safe to ignore if functionality works).

📈 Future Enhancements
Add a configuration file to store credentials and search keywords.
Integrate with a testing framework (TestNG/JUnit).
Add logs using a logger (Log4j).
Add more screenshots and better reporting.
Extend to other job portals (Indeed, Naukri, etc.)

🤝 Contributing
Contributions are welcome! Please fork the repository and submit a pull request.

📬 Contact
Feel free to reach out with any questions or feedback:
GitHub: M2st-commits

💡 Acknowledgements
Thanks to Selenium and WebDriverManager for making automation easy.
Inspired by real-world automation challenges.

📜 License
This project is open-source under the MIT License.
#   A u t o m a t e - J o b - S e a r c h - a n d - A p p l i c a t i o n - o n - S h i n e - J o b s  
 