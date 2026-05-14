<?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\Hash;
use App\Models\User;
use App\Models\Post;

class DatabaseSeeder extends Seeder
{
    public function run(): void
    {
        // Create users
        $ahmed   = User::create(['name' => 'Ahmed',   'email' => 'ahmed@example.com',   'password' => Hash::make('password')]);
        $mohamed = User::create(['name' => 'Mohamed', 'email' => 'mohamed@example.com', 'password' => Hash::make('password')]);
        $ali     = User::create(['name' => 'Ali',     'email' => 'ali@example.com',     'password' => Hash::make('password')]);

        // Create posts
        Post::create(['title' => 'Learn PHP',        'content' => 'An introduction to PHP programming.',   'author_id' => $ahmed->id,   'created_at' => '2018-04-10']);
        Post::create(['title' => 'Solid Principles',  'content' => 'Understanding SOLID design principles.', 'author_id' => $mohamed->id, 'created_at' => '2018-04-12']);
        Post::create(['title' => 'Design Patterns',   'content' => 'Common software design patterns.',       'author_id' => $ali->id,     'created_at' => '2018-04-13']);

        $this->call(PostSeeder::class);
    }
}
