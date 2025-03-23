# ProGymHome

Ngày nay, tỉ lệ mọi người bị các vấn đề về sức khỏe ngày càng gia tăng, đặc biệt là các nhân viên văn phòng và các lập trình viên của chúng ta. Các vấn đề về cột sống, trĩ, đau lưng, mỏi vai luôn đến từ việc ngồi nhiều cũng như lười tập luyện

Ứng dụng PROGYMHOME cung cấp các giải pháp để người dùng có thể tập luyện theo các bài tập được sắp xếp bởi chuyên gia, nâng cao văn hóa tập luyện ràn luyện sức khỏe, giảm thiểu bệnh tật, thư giãn sau những giờ làm việc

## Author
- [@anphuc2005](https://github.com/anphuc2005/ProGymHome)

## Demo
- [Demo](https://youtu.be/X3cj-kZtjnM)

## Screen Shot

<img src= "ProGYMHOME\img dự án\img1.png">
<img src= "ProGYMHOME\img dự án\img2.png">
<img src= "ProGYMHOME\img dự án\img3.png">
<img src= "ProGYMHOME\img dự án\img4.png">
<img src= "ProGYMHOME\img dự án\img 5.png">
<img src= "ProGYMHOME\img dự án\img6.png">

## ClassDiagram và ActivityDiagram

<img src="ProGYMHOME\UML\ClassDiagram.drawio.png">

<img src="ProGYMHOME\UML\ActivityDiagram.drawio.png">

## Features
- Các chức năng chính của ứng dụng:
  - Đăng nhập, đăng kí tài khoản cho ứng dụng
  - SetUp thông tin cá nhân
  - Tập theo các bài tập được list sẵn của ứng dụng
  - Vào chế độ Customize để tự setup bài tập cá nhân của người dùng
  - Theo dõi tiến trình tập luyện của người dùng, cập nhật bài tập đã tập vào dữ liệu của người dùng
  - Cập nhật thông tin về sức khỏe của người dùng
  - Màn hình tập luyện dễ tương tác, có video hướng dẫn người dùng tập luyện

## File Structure
```bash
ProGymHome/
│── src/
│   ├── main/
│   │   ├── java/com/example/progymhome
│   │   │   ├── controllers/
│   │   │   │   ├── AddLessonController.java
│   │   │   │   ├── CustomizeController.java
│   │   │   │   ├── PraticeScreen.java
│   │   │   │   ├── ProfileScreenController.java
│   │   │   │   ├── ProfileSetUpController.java
│   │   │   │   ├── SetRepController.java
│   │   │   │   ├── SignInController.java
│   │   │   │   ├── SignupController.java
│   │   │   │   ├── SwitchScreenController.java
│   │   │   │   ├── UserProgressController.java
│   │   │   │   ├── WelcomeScreenController.java
│   │   │   │   └── WorkoutController.java
│   │   │   │   
│   │   │   ├── User/
│   │   │   │   ├── UserDetail.java
│   │   │   │   ├── UserSession.java
│   │   │   │   ├── UserListSession.java
│   │   │   │   ├── UserManager.java
│   │   │   │   └── UserData.json
│   │   │   │   
│   │   │   ├── Lesson/
│   │   │   │   ├── LessonImage.java
│   │   │   │   ├── LessonLink.java
│   │   │   │   
│   │   │   
│   │   │   
│   │   ├── resources
│   │   │   ├── images/
│   │   │   │   ├── icons/
│   │   │   │   ├── img/
│   │   │   │   ├── logos/
│   │   │   │   
│   │   │   ├── /com/example/progymhome
│   │   │   │   ├── add-screen.fxml
│   │   │   │   ├── customize-screen.fxml
│   │   │   │   ├── finish-screen.fxml
│   │   │   │   ├── pratice-screen.fxml
│   │   │   │   ├── profile-screen.fxml
│   │   │   │   ├── profile-set-screen.fxml
│   │   │   │   ├── set-rep-screen.css
│   │   │   │   ├── sign-in.fxml
│   │   │   │   ├── sign-up.fxml
│   │   │   │   ├── user-progress-screen.fxml
│   │   │   │   ├── welcome-screen.fxml
│   │   │   │   ├── workout-screen.css
 
```
## Requirements
- Corrento JDK 22
- Maven 4.0.0
- JavaFX 23.0.2
- Java 11

## Installation
- Cách sử dụng dự án
  - Clone repo
  - Mở bằng file AppLaucher đã để sẵn trong folder