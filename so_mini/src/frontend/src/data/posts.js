import CommentItem from '../models/comment/CommentItem'

let comments = [
  new CommentItem('jihyun', '02.17 12:30', '피곤하다'),
  new CommentItem('jieun', '02.17 12:40', '내일 어떻게 일어나지'),
  new CommentItem('sol_123', '02.17 12:50', '이힝힝유ㅜㅠㅜㅠㅜ'),
];

export default [{
  userName: "jieun123",
  userImage: "src//assets//example1.jpg",
  postImage: "src//assets//example2.jpg",
  location: "Starbucks Sadang",
  likes: 36,
  hasBeenLiked: false,
  caption: "It's sunny day:)",
  comments: comments
},
  {
    userName: "jihyun",
    userImage: "src//assets//example2.jpg",
    postImage: "src//assets//example2.jpg",
    location: "amsterdam",
    likes: 20,
    hasBeenLiked: false,
    caption: "Views from the six...",
    comments: comments
  },
  {
    userName: "soll123",
    userImage: "src//assets//example2.jpg",
    postImage: "src//assets//example2.jpg",
    location: "paris",
    likes: 49,
    hasBeenLiked: false,
    caption: "Current mood 🐶",
    comments: comments
  }
];


