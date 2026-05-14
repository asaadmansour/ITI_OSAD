<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Post</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 40px;
            background: #fff;
            color: #333;
        }

        .form-group {
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin-bottom: 6px;
            font-size: 14px;
        }

        input[type="text"],
        textarea,
        select {
            width: 100%;
            padding: 8px 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 14px;
            box-sizing: border-box;
        }

        textarea {
            height: 120px;
            resize: vertical;
        }

        select:focus {
            outline: none;
            border-color: #80bdff;
            box-shadow: 0 0 0 2px rgba(0,123,255,0.25);
        }

        .btn-update {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 8px 18px;
            border-radius: 4px;
            font-size: 14px;
            cursor: pointer;
        }

        .btn-update:hover { background-color: #0056b3; }
    </style>
</head>
<body>

    {{-- PUT/PATCH can't be sent via HTML forms, so we POST and spoof the method --}}
    <form action="{{ route('posts.update', $post->id) }}" method="POST">
        @csrf
        @method('PUT')

        <div class="form-group">
            <label for="title">Title</label>
            <input type="text" id="title" name="title" value="{{ old('title', $post->title) }}">
        </div>

        <div class="form-group">
            <label for="content">Description</label>
            <textarea id="content" name="content">{{ old('content', $post->content) }}</textarea>
        </div>

        <div class="form-group">
            <label for="author_id">Post Creator</label>
            <select id="author_id" name="author_id">
                @foreach ($users as $user)
                    <option value="{{ $user->id }}"
                        {{ old('author_id', $post->author_id) == $user->id ? 'selected' : '' }}>
                        {{ $user->name }} 
                    </option>
                @endforeach
            </select>
        </div>

        <button type="submit" class="btn-update">Update</button>
    </form>

</body>
</html>
