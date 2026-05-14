<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>{{ $post->title }}</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 40px;
            background: #f9f9f9;
            color: #333;
        }

        .card {
            background: #fff;
            border: 1px solid #ddd;
            border-radius: 6px;
            padding: 30px;
            max-width: 700px;
        }

        h1 {
            margin-top: 0;
            font-size: 24px;
        }

        .meta {
            color: #888;
            font-size: 13px;
            margin-bottom: 20px;
        }

        p {
            line-height: 1.7;
        }

        .btn-back {
            display: inline-block;
            margin-top: 20px;
            padding: 7px 16px;
            background: #007bff;
            color: #fff;
            border-radius: 4px;
            text-decoration: none;
            font-size: 14px;
        }

        .btn-back:hover { background: #0056b3; }
    </style>
</head>
<body>

    <div class="card">
        <h1>{{ $post->title }}</h1>
        <div class="meta">
            Posted by <strong>{{ $post->author->name }}</strong> &nbsp;|&nbsp; {{ $post->created_at->format('Y-m-d') }}
        </div>
        <p>{{ $post->content }}</p>
        <a href="{{ route('posts.index') }}" class="btn-back">← Back to Posts</a>
    </div>

</body>
</html>
