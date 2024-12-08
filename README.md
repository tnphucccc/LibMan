[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
# LibMan

<!-- TABLE OF CONTENTS -->
1. [Introduction](#Introduction)
2. [Features](#Features)
3. [Challenges](#Challenges)

<!-- <details>
<summary>Table of Contents</summary>
<ol>
    <li>
        <a href="#Introduction">Introduction</a>
        <ul>
            <li><a href="#Team-Members">Team Members</a></li>
            <li><a href="#How-to-Run">How to Run</a></li>
        </ul>
    </li>
    <li><a href="#Features">Features</a></li>
    <li><a href="#Challenges">Challenges</a></li>
</ol>
</details> -->

<!-- ABOUT THE PROJECT -->
## Introduction <a name="Introduction"></a>
<div style = "text-align: justify">
LibMan is a library management system that helps librarians manage books, members, and borrowing/returning books. 
The system is built using Java SpringBoot for the backend and React for frontend.
</div>

### Team Members
| Order |          Name           | Student ID  |
|:-----:|:-----------------------:|:-----------:|
|   1   |    Tran Nguyen Phuc     | ITCSIU21097 |
|   2   |  Nguyen Mach Khang Huy  | ITCSIU21072 |
|   3   |      Bui Cong Vinh      | ITCSIU22165 |
|   4   | Nguyen Bach Dong Phuong | ITCSIU22118 |
|   5   |  Nguyen Thi Quynh Nga   | ITCSIU22094 |
|   6   |       Le Minh Duy       | ITCSIU22037 |
|   7   |    Nguyen Minh Viet     | ITDSIU21130 |
|   8   |      Tran Quoc Bao      | ITITWE20033 |

### How to Run
1. Clone the repo
   ```sh
   git clone https://github.com/tnphucccc/LibMan.git
   ```
2. Run the backend
   ```sh
    cd backend
    mvn spring-boot:run
    ```
3. Run the frontend
    ```sh
     cd frontend
     npm install
     npm run start
     ```
4. Open your browser and go to `http://localhost:5173/`

## Features <a name="Features"></a>
- [x] Add, update, delete books
- [x] Add, update, delete authors
- [x] Add, update, delete members
- [x] Borrow, return books
- [x] View borrowing history
- [x] Search books

## Challenges <a name="Challenges"></a>

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/tnphucccc/LibMan.svg?style=for-the-badge
[contributors-url]: https://github.com/tnphucccc/LibMan/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/tnphucccc/LibMan.svg?style=for-the-badge
[forks-url]: https://github.com/tnphucccc/LibMan/network/members
[stars-shield]: https://img.shields.io/github/stars/tnphucccc/LibMan.svg?style=for-the-badge
[stars-url]: https://github.com/tnphucccc/LibMan/stargazers
[issues-shield]: https://img.shields.io/github/issues/tnphucccc/LibMan.svg?style=for-the-badge
[issues-url]: https://github.com/tnphucccc/LibMan/issues