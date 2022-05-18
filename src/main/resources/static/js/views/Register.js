export default function Register(){
    return `
    <!DOCTYPE html>
    <html lang="en">
    <head>
    
    
</head>
    `
}

export function RegisterEvent(){
    $(document).on('click', '#register-btn', function(e){
        const newUser = {
            username: $('#userName').val(),
            email: $('#email').val(),
            password: $('#password').val()
        }
      const options = {
            headers: {
                "Content-Type":"application/json"
            },
          method:'POST';
            body: JSON.stringify(reqBody)
      }

      fetch("http://localhost:8080/api/users", options)
          .then(res => res.json())
          .then(data => console.log()
          .then(err => log)
    })
}