<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Posts</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 30px;
            background: #f9f9f9;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            background: #fff;
        }

        thead tr {
            border-bottom: 2px solid #ddd;
        }

        th {
            text-align: left;
            padding: 12px 16px;
            font-weight: bold;
            color: #333;
        }

        td {
            padding: 14px 16px;
            border-bottom: 1px solid #eee;
            color: #444;
        }

        .btn {
            display: inline-block;
            padding: 5px 12px;
            border: none;
            border-radius: 4px;
            color: #fff;
            font-size: 13px;
            cursor: pointer;
            text-decoration: none;
            margin-right: 4px;
        }

        .btn-view   { background-color: #17a2b8; }
        .btn-edit   { background-color: #007bff; }
        .btn-delete { background-color: #dc3545; }

        .btn:hover { opacity: 0.85; }
    </style>
</head>
<body>

    <table>
        <thead>
            <tr>
                <th>#</th>
                <th>Title</th>
                <th>Posted By</th>
                <th>Created At</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            @foreach ($posts as $post)
            <tr>
                <td>{{ $loop->iteration }}</td>
                <td>{{ $post->title }}</td>
                <td>{{ $post->author->name }}</td>
                <td>{{ $post->created_at->format('Y-m-d') }}</td>
                <td>
                    <a href="{{ route('posts.show', $post->id) }}" class="btn btn-view">View</a>
                    <a href="{{ route('posts.edit', $post->id) }}" class="btn btn-edit">Edit</a>
                    <form action="{{ route('posts.destroy', $post->id) }}" method="POST" style="display:inline;">
                        @csrf
                        @method('DELETE')
                        <button type="submit" class="btn btn-delete">Delete</button>
                    </form>
                </td>
            </tr>
            @endforeach
        </tbody>
    </table>

</body>
</html>
